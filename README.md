# :iphone:SYM - Labo 1 - Introduction à Android

:bust_in_silhouette: **Auteurs :** `Alexis Allemann` ,  `Hakim Balestrieri` et `Christian Gomes`

:page_facing_up: **En bref :** Ce repository contient la réalisation du laboratoire nommé "Introduction Android" de l'[HEIG-VD](https://heig-vd.ch/). Ce travail est réalisé durant le cours de SYM.

:dart: **Objectifs :** Ce laboratoire est constitué de plusieurs manipulations destinées à implémenter une application élémentaire sur un émulateur et/ou sur un smartphone Android dans le but de se familiariser avec l’environnement (IDE et SDK) de développement Android.

## :thinking: Premières constatations

### Langue de l'interface

Afin d'obtenir une application multi-langues, il faut créer un package `strings-xx.xml` (xx remplacé par le raccourci de la langue ; exemple fr pour le français) dans le dossier `values` des ressources du projet.

En fonction de la langue du système du mobile, le bon fichier string est utilisé automatiquement par le mobile. C'est donc le principal intérêt de regrouper les chaînes de caractères dans des fichiers XML indépendants en plus de ne pas avoir à dupliquer les layouts pour chaque langue.

Lorsqu'une traduction est manquante dans une langue, la langue par défaut est utilisée (via le fichier `strings.xml` ). Si un lien manque dans le dossier de la langue de base, il y a une erreur à la compilation (lors du mapping des ressources avec les strings).

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

Pour faire deux colonnes dans notre application (une avec l'image et une avec les inputs), nous avons utilisé le composant `LinearLayout` qui permet de distribuer des blocs horizontalement. Ensuite, nous avons réutilisé les composants `constraintLayout` pour facilement aligner les inputs et l'image.

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

> Cette action génère automatiquement la classe de l'activité, son layout XML et l'ajout au Manifest.

Pour lancer l'activité, voici le code nécessaire :

```kotlin
val intent = Intent(this , UserProfileActivity::class.java)
startActivity(intent)
```

> Il faut utiliser un objet de la classe Intent

### Passage de paramètres à la nouvelle activité

Voici comment ajouter des paramètres à un objet de la classe `Intent` :

```kotlin
// Placer cette constante en dehors de la classe de l'activité
const val USER_EMAIL = "ch.heigvd.iict.sym.labo1.USER_EMAIL"

val intent = Intent(this , UserProfileActivity::class.java).apply {
    putExtra(USER_EMAIL, emailInput)
}
```

Ici, nous avons ajouter le paramètre avec la clé `"ch.heigvd.iict.sym.labo1.USER_EMAIL"`.

> La définition d'une constante hors de la classe permet de facilement récupérer la clé depuis une autre activité

Pour récupérer le paramètre, il suffit d'utiliser le code suivant : 

```kotlin
intent.getStringExtra(USER_EMAIL)
```

> `intent` est en fait l'appel à la méthode `getIntent()` de la super classe `Activity`

### Permissions simples

Pour autoriser une application Android à accéder à internet, il faut ajouter la balise suivante dans le fichier `AndroidManifest.xml` :

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

