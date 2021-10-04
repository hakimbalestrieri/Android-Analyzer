# :iphone:SYM - Labo 1 - Introduction à Android

:bust_in_silhouette: **Auteurs :** `Alexis Allemann` ,  `Hakim Balestrieri` et `Christian Gomes`

:page_facing_up: **En bref :** Ce repository contient la réalisation du laboratoire nommé "Introduction Android" de l'[HEIG-VD](https://heig-vd.ch/). Ce travail est réalisé durant le cours de SYM.

:dart: **Objectifs :** Ce laboratoire est constitué de plusieurs manipulations destinées à implémenter une application élémentaire sur un émulateur et/ou sur un smartphone Android dans le but de se familiariser avec l’environnement (IDE et SDK) de développement Android.

## :thinking: Premières constatations

### Langue de l'interface

Afin d'obtenir une application multi-langues, il faut créer un package `strings-xx.xml` (xx remplacé par le raccourci de la langue ; exemple fr pour le français) dans le dossier `values` des ressources du projet.

En fonction de la langue du système du mobile, le bon fichier string est utilisé. C'est donc le principal intérêt de regrouper les chaînes de caractères dans des fichiers XML indépendants.

Lorsqu'une traduction est manquante dans une langue, la langue par défaut est utilisée (via le fichier `strings.xml` ). Si un lien manque dans le dossier de la langue de base, il y a une erreur à la compilation (lors du mapping des ressources avec les strings).

### Champs textuels de saisie

Afin d'enlever les suggestions d'un champ, le type `textNoSuggestions` peut être utilisé. Pour ceci, il faut ajouter l'attribut suivant à la balise XML du champ : 

```xml
android:inputType="textNoSuggestions"
```

Dans notre cas, nous sommes allés plus loin que de supprimer les suggestions en utilisant le type de champ `textEmailAddress` qui facilite la saisie d'un email.

Pour le mot de passe, nous avons utilisé le type `textPassword`  (toujours sur la propriété `android:inputType`.

### Mode paysage

Pour le mode paysage, nous avons créer un nouveau layout. Les layouts en paysages sont créés dans un dossier `layout-land` dans le dossier des ressources contrairement aux layouts en portrait qui se trouvent dans un dossier `layout`.



