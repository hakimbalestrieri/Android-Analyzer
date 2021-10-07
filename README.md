# :iphone:SYM - Labo 1 - Introduction à Android

:bust_in_silhouette: **Auteurs :** `Alexis Allemann` ,  `Hakim Balestrieri` et `Christian Gomes`

:page_facing_up: **En bref :** Ce repository contient la réalisation du laboratoire nommé "Introduction Android" de l'[HEIG-VD](https://heig-vd.ch/). Ce travail est réalisé durant le cours de SYM.

:dart: **Objectifs :** Ce laboratoire est constitué de plusieurs manipulations destinées à implémenter une application élémentaire sur un émulateur et/ou sur un smartphone Android dans le but de se familiariser avec l’environnement (IDE et SDK) de développement Android.

## :thinking: Premières constatations

### Langue de l'interface

Afin d'obtenir une application multi-langues, il faut créer un package `strings-xx.xml` (xx remplacé par le raccourci de la langue ; exemple fr pour le français) dans le dossier `values` des ressources du projet.

En fonction de la langue du système du mobile, le bon fichier string est utilisé automatiquement par le mobile. C'est donc le principal intérêt de regrouper les chaînes de caractères dans des fichiers XML indépendants en plus de ne pas avoir à dupliquer les layouts pour chaque langue.

Lorsqu'une traduction est manquante dans une langue, la version dans la langue par défaut est utilisée (via le fichier `strings.xml` ). Si un lien manque dans le dossier de la langue par défaut, il y a une erreur à la compilation (lors du mapping des ressources avec les strings).

> Nous avons utilisé l'outil "Translation Editor" de Android Studio pour facilement gérer les langues

### Champs textuels de saisie

Afin d'enlever les suggestions d'un champ, le type `textNoSuggestions` peut être utilisé. Pour ceci, il faut ajouter l'attribut suivant à la balise XML du champ : 

```xml
android:inputType="textNoSuggestions"
```

Dans notre cas, nous sommes allés plus loin que de supprimer les suggestions en utilisant le type de champ `textEmailAddress` qui facilite la saisie d'un email avec un clavier adapté.

Pour le mot de passe, nous avons utilisé le type `textPassword`  (toujours sur la propriété `android:inputType`.

> Tant les types `textEmailAddress`et `textPassword` désactivent les suggestions

### Mode paysage

Pour le mode paysage, nous avons créé un nouveau layout. Les layouts en paysages sont créés dans le dossier des ressources dans un dossier `layout-land` contrairement aux layouts en portrait qui se trouvent dans un dossier `layout`.

Pour faire deux colonnes dans notre application (une avec l'image et une avec les inputs), nous avons utilisé le composant `LinearLayout` qui permet de distribuer des blocs horizontalement. Ensuite, nous avons réutilisé le composant `constraintLayout` pour facilement aligner les inputs et l'image.

## :pause_button: Gestion des événements et mise à jour de l'interface utilisateur

### Vérification du format de l’e-mail

Pour tester que l'email est valide (qu'il contient le caractère `@`), nous avons récupérer la valeur du champ de l'email via l'activité `MainActivity`.

Pour afficher un toast si l'email n'est pas valide, voici le code nécessaire : 

```kotlin
Toast.makeText(applicationContext, getString(R.string.main_invalid_email), Toast.LENGTH_LONG).show()
```

> Ici, on récupère la string avec le message d'erreur dans la bonne langue et on affiche le toast durant 5 secondes (Toast.LENGTH_LONG).

### Vérification du couple e-mail / mot de passe

Pour tester que le couple email / mot de passe, nous avons récupérer la valeur du champ de l'email via l'activité `MainActivity`.

Pour afficher une fenêtre de dialogue, voici le code nécessaire : 

```kotlin
val builder = AlertDialog.Builder(this)
builder.setTitle(getString(R.string.main_invalid_user_title))
builder.setMessage(getString(R.string.main_invalid_user_message))
builder.setPositiveButton(android.R.string.ok) { _, _ -> }
builder.show()
```

> Ici, on crée un builder de type `AlertDialog`. On définit ensuite ses paramètres (titre, message et actions) puis on l'affiche.

## :arrow_right: Passage à une autre activité

### Création et lancement de la nouvelle activité

L'activité `UserProfileActivity` a été crée via les assistants graphique de Android Studio. Nous avons choisi le modèle d'activité `EmptyActivity` qui définit un simple layout vide.

> Cette action génère automatiquement la classe de l'activité, son layout XML et l'ajoute au Manifest

Pour lancer l'activité, voici le code nécessaire :

```kotlin
val intent = Intent(this , UserProfileActivity::class.java)
startActivity(intent)
```

> Il faut utiliser un objet de la classe Intent

### Passage de paramètres à la nouvelle activité

Voici comment ajouter des paramètres à un objet de la classe `Intent` :

```kotlin
// Placer cette constante en dehors de la classe de l'activité ou dans le companion object
const val USER_EMAIL = "ch.heigvd.iict.sym.labo1.USER_EMAIL"

val intent = Intent(this , UserProfileActivity::class.java).apply {
    putExtra(USER_EMAIL, emailInput)
}
```

Ici, nous avons ajouter le paramètre avec la clé `"ch.heigvd.iict.sym.labo1.USER_EMAIL"`.

> La définition d'une constante hors de la classe permet de facilement récupérer la clé depuis une autre activité

Pour récupérer le paramètre, il suffit d'utiliser le code suivant : 

```kotlin
intent.getStringExtra(MainActivity.USER_EMAILL)
```

> `intent` est en fait l'appel à la méthode `getIntent()` de la super classe `Activity`

### Permissions simples

Pour autoriser une application Android à accéder à internet et ses ressources, il faut ajouter la balise suivante dans le fichier `AndroidManifest.xml` :

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## :leftwards_arrow_with_hook: Navigation entre les activités

### Création et lancement de la nouvelle activité

L'activité `NewAccountActivity` a été crée via les assistants graphique de Android Studio. Nous avons choisi le modèle d'activité `EmptyActivity` qui définit un simple layout vide. Ensuite, nous avons importé les composants et le code nécessaire depuis l'activité principale.

**Résultat d'une activité - mécanisme d'origine :**

Pour utiliser cette option, il est nécessaire de lancer l'activité via la méthode `startActivityForResult()` :

```kotlin
startActivityForResult(new Intent(Intent.ACTION_PICK,new Uri("content://contacts")), 0);
```

> Ici le 1er paramètre est l'intent et le deuxième paramètre est un int qui définit le code de la requête. Ce code sera utilisé pour récupérer la réponse

Pour récupérer la réponse, il faut redéfinir la méthode `onActivityResult()` de la classe parente `Activity` :

```kotlin
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     if (requestCode == 0) {
         if (resultCode == RESULT_OK) {
             // handle result
         }
     }
}
```

> En ligne 2, on fait matche le code de la requête

**Résultat d'une activité - librairie AndroidX :**

Avec AndroidX, on peut définir une fonction de callback qui traite le résultat :

```kotlin
val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            // handle result
        }
    }
```

Il suffit ensuite de lancer l'activité avec : 

```kotlin
startForResult.launch(Intent(this , NewAccountActivity::class.java))
```

**Comparaison des méthodes :**

L'avantage de la première méthode est sa simplicité. En effet, elle est très rapide à mettre en place et à comprendre. Cependant, si l'on doit gérer un grand nombre de résultats cette solution n'est pas très modulable. Le nombre de "if" imbriqués vont augmenter, le code sera étroitement couplé et donc plus difficile à tester aussi.

La deuxième méthode propose une abstraction qui permet de gérer la méthode `onActivityResult()` dans une structure très propre et réutilisable. Elle est cependant plus compliquée à comprendre et à mettre en place. Avec cette solution, il est aussi envisageable de créer une classe dédiée au traitement du résultat d'une activité. Cette classe peut alors être instanciée depuis diverses activités qui souhaitent traiter les même résultats.

### Affichage d’une image

Pour ajouter une image, nous sommes passés par l'assistant d'import de Android Studio. Le dossier qui contient les images se trouve dans les ressources et est nommé "drawable" : `/res/drawable`.

Il existe deux façons de définir et d'instancier un `Drawable` en plus d'utiliser les constructeurs de classe :

- utiliser une ressource d'image (un fichier bitmap) enregistrée dans votre projet
- utiliser une ressource XML qui définit les propriétés pouvant être dessinées

Les images des ressources du dossier `/res/drawable` peuvent être automatiquement optimisées avec une compression d'image sans perte pendant le processus de construction.

Un fichier graphique bitmap (.png, .jpg ou .gif) crée un `BitmapDrawable`. L'un des inconvénients associés à une image bitmap est qu'elle n'a pas tendance à se redimensionner très bien. S'il peut être facile de réduire une image sans perte de clarté, il n'est pas facile d'agrandir l'image sans que l'image ne devienne pixelisée. Un autre inconvénient associé à un bitmap est la grande taille du fichier.

Les avantages de l'utilisation de graphiques vectoriels sont d'avoir une petite taille de fichier et la possibilité de redimensionner l'image à n'importe quelle taille sans perte de qualité

Il n'est pas possible d'utiliser des images vectorielles pour tous les types d'images. Le format vectoriel est très adapté aux logos ou aux icones. Cependant, une photo composée de pixels ne peut pas être vectorisée. En effet, les graphiques vectoriels sont constitués d'objets, de lignes, de courbes et de texte tandis que les images sont constituées d'une collection de points ou de pixels.

### Factorisation du code

Nous avons créer une classe utilitaire nommée `Utils` qui met à disposition les méthodes suivants dans son `companion` :

- `validateEmailAndPassword(email: EditText, password: EditText, context: Context)`

  Cette fonction prend en paramètres un champ email, un champ mot de passe et le contexte de l'application. 

  Elle permet de faire les vérifications des champs et de leurs contenus et d'afficher les erreurs nécessaires.

  Un booléen est rendu afin d'indiquer si le contenu des champs est valide.

- `resetEditTextFields(fields: List<EditText>)`

  Cette fonction prend en paramètre une liste de champs textes à réinitialiser.

  La réinitialisation efface le texte et les erreurs de chaque champs.

  Cette fonction ne retourne rien.

### Cycle de vie

// TODO
