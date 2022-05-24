# :iphone:SYM - Labo 1 - Introduction de Android

:bust_in_silhouette: **Auteurs :** `Alexis Allemann` ,  `Hakim Balestrieri` et `Christian Gomes`

:page_facing_up: **En bref :** Ce repository contient la r?alisation du laboratoire nomm? "Introduction Android" de l'[HEIG-VD](https://heig-vd.ch/). Ce travail est r?alis? durant le cours de SYM.

:dart: **Objectifs :** Ce laboratoire est constitu? de plusieurs manipulations destin?es de impl?menter une application ?l?mentaire sur un ?mulateur et/ou sur un smartphone Android dans le but de se familiariser avec l'environnement (IDE et SDK) de d?veloppement Android.

## :thinking: Premières constatations

### Langue de l'interface

Afin d'obtenir une application multi-langues, il faut avoir des packages diff?rents `values-xx` (xx remplac? par le raccourci de la langue ; exemple fr pour le fran?ais) qui contiendra un fichier `strings.xml` la langue. 

En fonction de la langue du syst?me du mobile, le bon fichier string est utilis? automatiquement par le mobile. C'est donc le principal int?r?t de regrouper les cha?nes de caract?res dans des fichiers XML ind?pendants en plus de ne pas avoir de dupliquer les layouts pour chaque langue.

Lorsqu'une traduction est manquante dans une langue, la version dans la langue par d?faut est utilis?e (via le fichier `strings.xml` ). Si un lien manque dans le dossier de la langue par d?faut, il y a une erreur de la compilation (lors du mapping des ressources avec les strings).

> Nous avons utilis? l'outil "Translation Editor" de Android Studio pour facilement g?rer les langues

### Champs textuels de saisie

Afin d'enlever les suggestions d'un champ, le type `textNoSuggestions` peut ?tre utilis?. Pour ceci, il faut ajouter l'attribut suivant de la balise XML du champ : 

```xml
android:inputType="textNoSuggestions"
```

Dans notre cas, nous sommes all?s plus loin que de supprimer les suggestions en utilisant le type de champ `textEmailAddress` qui facilite la saisie d'un email avec un clavier adapt?.

Pour le mot de passe, nous avons utilis? le type `textPassword`  (toujours sur la propri?t? `android:inputType`.

> Tant les types `textEmailAddress`et `textPassword` d?sactivent les suggestions

### Mode paysage

Pour le mode paysage, nous avons cr?? un nouveau layout. Les layouts en paysages sont cr??s dans le dossier des ressources dans un dossier `layout-land` contrairement aux layouts en portrait qui se trouvent dans un dossier `layout`.

Pour faire deux colonnes dans notre application (une avec l'image et une avec les inputs), nous avons utilis? le composant `LinearLayout` qui permet de distribuer des blocs horizontalement. Ensuite, nous avons r?utilis? le composant `constraintLayout` pour facilement aligner les inputs et l'image.

## :pause_button: Gestion des ?v?nements et mise de jour de l'interface utilisateur

### V?rification du format de l'e-mail

Pour tester que l'email est valide (qu'il contient le caract?re `@`), nous avons r?cup?r? la valeur du champ de l'email via l'activit? `MainActivity`.

Pour afficher un toast si l'email n'est pas valide, voici le code n?cessaire : 

```kotlin
Toast.makeText(applicationContext, getString(R.string.main_invalid_email), Toast.LENGTH_LONG).show()
```

> Ici, on r?cup?re la string avec le message d'erreur dans la bonne langue et on affiche le toast durant 5 secondes (Toast.LENGTH_LONG).

### V?rification du couple e-mail / mot de passe

Pour tester le couple email / mot de passe, nous avons r?cup?r? la valeur du champ de l'email via l'activit? `MainActivity`.

Pour afficher une fen?tre de dialogue, voici le code n?cessaire : 

```kotlin
val builder = AlertDialog.Builder(this)
builder.setTitle(getString(R.string.main_invalid_user_title))
builder.setMessage(getString(R.string.main_invalid_user_message))
builder.setPositiveButton(android.R.string.ok) { _, _ -> }
builder.show()
```

> Ici, on cr?e un builder de type `AlertDialog`. On d?finit ensuite ses param?tres (titre, message et actions) puis on l'affiche.

## :arrow_right: Passage d'une autre activit?

### Cr?ation et lancement de la nouvelle activit?

L'activit? `UserProfileActivity` a ?t? cr?e via les assistants graphique de Android Studio. Nous avons choisi le mod?le d'activit? `EmptyActivity` qui d?finit un simple layout vide.

> Cette action g?n?re automatiquement la classe de l'activit?, son layout XML et l'ajoute au Manifest

Pour lancer l'activit?, voici le code n?cessaire :

```kotlin
val intent = Intent(this , UserProfileActivity::class.java)
startActivity(intent)
```

> Il faut utiliser un objet de la classe Intent

### Passage de param?tres de la nouvelle activit?

Voici comment ajouter des param?tres de un objet de la classe `Intent` :

```kotlin
// Placer cette constante en dehors de la classe de l'activit? ou dans le companion object
const val USER_EMAIL = "ch.heigvd.iict.sym.labo1.USER_EMAIL"
val intent = Intent(this , UserProfileActivity::class.java).apply {
    putExtra(USER_EMAIL, emailInput)
}
```

Ici, nous avons ajout? le param?tre avec la cl? `"ch.heigvd.iict.sym.labo1.USER_EMAIL"`.

> La d?finition d'une constante hors de la classe permet de facilement r?cup?rer la cl? depuis une autre activit?

Pour r?cup?rer le param?tre, il suffit d'utiliser le code suivant : 

```kotlin
intent.getStringExtra(MainActivity.USER_EMAIL)
```

> `intent` est en fait l'appel ? la m?thode `getIntent()` de la super classe `Activity`

### Permissions simples

Pour autoriser une application Android de acc?der de internet et ses ressources, il faut ajouter la balise suivante dans le fichier `AndroidManifest.xml` :

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## :leftwards_arrow_with_hook: Navigation entre les activit?s

### Cr?ation et lancement de la nouvelle activit?

L'activit? `NewAccountActivity` a ?t? cr?e via les assistants graphique de Android Studio. Nous avons choisi le mod?le d'activit? `EmptyActivity` qui d?finit un simple layout vide. Ensuite, nous avons import? les composants et le code n?cessaire depuis l'activit? principale.

**R?sultat d'une activit? - m?canisme d'origine :**

Pour utiliser cette option, il est n?cessaire de lancer l'activit? via la m?thode `startActivityForResult()` :

```kotlin
startActivityForResult(new Intent(Intent.ACTION_PICK,new Uri("content://contacts")), 0);
```

> Ici le 1er param?tre est l'intent et le deuxi?me param?tre est un int qui d?finit le code de la requ?te. Ce code sera utilis? pour r?cup?rer la r?ponse

Pour r?cup?rer la r?ponse, il faut red?finir la m?thode `onActivityResult()` de la classe parente `Activity` :

```kotlin
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     if (requestCode == 0) {
         if (resultCode == RESULT_OK) {
             // handle result
         }
     }
}
```


En ligne 2, on fait matcher le code de la requ?te

**R?sultat d'une activit? - librairie AndroidX :**

Avec AndroidX, on peut d?finir une fonction de callback qui traite le r?sultat :

```kotlin
val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
     if (result.resultCode == Activity.RESULT_OK) {
         // handle result
     }
}
```

?    Il suffit ensuite de lancer l'activit? avec : 

```kotlin
startForResult.launch(Intent(this , NewAccountActivity::class.java))
```

**Comparaison des m?thodes :**

L'avantage de la premi?re m?thode est sa simplicit?. En effet, elle est tr?s rapide de mettre en place et de comprendre. Cependant, si l'on doit g?rer un grand nombre de r?sultats cette solution n'est pas tr?s modulable. Le nombre de "if" imbriqu?s vont augmenter, le code sera ?troitement coupl? et donc plus difficile de tester aussi.

La deuxi?me m?thode propose une abstraction qui permet de g?rer la m?thode `onActivityResult()` dans une structure tr?s propre et r?utilisable. Elle est cependant plus compliqu?e de comprendre et de mettre en place. Avec cette solution, il est aussi envisageable de cr?er une classe d?di?e au traitement du r?sultat d'une activit?. Cette classe peut alors ?tre instanci?e depuis diverses activit?s qui souhaitent traiter les m?me r?sultats.

### Affichage de une image

Pour ajouter une image, nous sommes pass?s par l'assistant d'import de Android Studio. Le dossier qui contient les images se trouve dans les ressources et est nomm? "drawable" : `/res/drawable`.

Il existe deux façons de d?finir et d'instancier un `Drawable` en plus d'utiliser les constructeurs de classe :

- utiliser une ressource d'image (un fichier bitmap) enregistr?e dans votre projet

- utiliser une ressource XML qui d?finit les propri?t?s pouvant ?tre dessin?es

Les images des ressources du dossier `/res/drawable` peuvent ?tre automatiquement optimis?es avec une compression d'image sans perte pendant le processus de construction.

Un fichier graphique bitmap (.png, .jpg ou .gif) cr?e un `BitmapDrawable`. L'un des inconv?nients associ?s de une image bitmap est qu'elle n'a pas tendance de tr?s bien se redimensionner. S'il peut ?tre facile de r?duire une image sans perte de clart?, il n'est pas facile d'agrandir l'image sans que l'image ne devienne pixelis?e. Un autre inconv?nient associ? ? une bitmap est la taille du fichier.

Les avantages de l'utilisation de graphiques vectoriels sont d'avoir une petite taille de fichier et la possibilit? de redimensionner l'image de n'importe quelle taille sans perte de qualit?.

Il n'est pas possible d'utiliser des images vectorielles pour tous les types d'images. Le format vectoriel est tr?s adapt? aux logos ou aux ic?nes. Cependant, une photo compos?e de pixels ne peut pas ?tre vectoris?e. En effet, les graphiques vectoriels sont constitu?s d'objets, de lignes, de courbes et de texte tandis que les images sont constitu?es d'une collection de points ou de pixels.

### Factorisation du code

Afin de factoriser le code redondant des activit?s `MainActivity` et `NewAccountActivity` nous avons cr?er une superclasse abstraite nomm?e `UserPasswordActivity`.

Voici une repr?sentation UML simplifi?e de notre impl?mentation : 

![](/doc/UML-Factorisation.png)

Les m?thodes `setContentView()` et `onSubmit(...)` doivent ?tre red?finies dans les classes enfant de la classe abstraite `UserPasswordActivity`.

Pour factoriser un layout, il est possible de cr?er des layouts r?-utilisables en cr?ant des fichiers xml. Ensuite, il est possible de les inclures en utilisant la balise `<include>`  :

```xml
<include layout="@layout/titlebar"/>
```

> La balise `<merge />` permet d'?liminer les groupes de vues redondantes dans la hi?rarchie de vues lors de l'inclusion d'une mise en page dans une autre.

### Cycle de vie

Pour r?aliser des logs sans duplications de code, nous avons cr?? une classe abstraite `LogsActivity` qui ?tend `AppCompatActivity`. L'ensemble de nos classes devant avoir des logs du cycle de vie impl?mentant cette super classe abstraite.

La m?thode `onCreate` est lanc?e lorsqu'une activit? d?marre suivie de `onStart` et de `onPostCreate`. Lors d'un changement d'activit?, l'ancienne activit? passe par la m?thode `onStop`. Lorsque que l'on revient sur une activit?, les m?thodes `onResume` et `onPostResume` sont appel?es. `onPause` est appel?e lorsque le contenu reste affich? sur l'activit? mais que celle-ci n'est plus active. Finalement `onDestroy` est appel?e lorsque l'on quitte une activit?.

Voici un sch?ma qui pr?sente les encha?nements : 

![](/doc/Android-Activity-Lifecycle.png)
