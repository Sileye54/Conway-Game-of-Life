# TP 1 - Conway (Fiche de réponses)

  - Auteur : Sileye Lamine, Guisse (`GUIS08369403`)
  - Date de remise : JJ/MM/AAAA
  - Estimation du temps de travail passé sur le projet : _xx_ heures.

## Réponses aux questions  
 
Les tailles de réponses sont données à titre indicatif, mais il est clair qu'une question sur quinze (15) points attends plus de matière dans la réponse qu'une question sur cinq (5). Ne faites pas un roman, soyez direct et allez droit au but dans votre argumentation.
 
### Question 1: Évolution du code légataire

_Notre jeu implémente bel et bien la règle du jeu de la vie. Dans le code source du programme, entre les lignes 50 et 61, on comptabilise le nombre de voisins en vie de chaque case dans la variable n. Entre les lignes 62 et 66, on attribue l'état d'une case en fonction de son état et du nombre de voisins en vie, conformément à la règle. De plus, avec les exemples fournis dans le projet et d'autres que l'on peut créer, on obtient le résultat attendu après exécution du programme._

### Question 2: Analyse des défauts du code légataire

_La classe principale, qui contient tout le code source, peut être divisée en plusieurs classes et modules afin de rendre le code plus lisible et plus facile à maintenir.Les exceptions attrapées avec try/catch pourraient être plus spécifiques. En cas d'erreur, le programme se termine sans message indiquant la source de l'erreur, comme on peut le voir aux lignes 21 et 42. On constate également que si la taille du plateau fourni est différente de celle du plateau en format texte et que le nombre de colonnes des lignes peut être différent_.

_Les variables cnt, f, r, d, gs, ns et n pourraient avoir des noms plus significatifs. L'initialisation de la variable cnt à -1 n'a aucun sens. On trouve également des bouts de code redondants qui pourraient être implémentés dans des fonctions. Par exemple, le code entre les lignes 51 et 53 est le même que celui entre les lignes 55 et 57._

### Question 3: Justification des choix de conception

_Nous avons proposé un modèle de conception qui découpe la classe Main en plusieurs classes ayant chacune une tâche précise et unique, ce qui offre une meilleure maintenabilité, une meilleure compréhension du code et une plus grande flexibilité en cas d'ajout de nouvelles fonctionnalités. Ce nouveau modèle offre également une meilleure gestion des erreurs, avec la création de classes d'exception spécifiques à chaque type d'erreur, accompagnées d'un message explicatif précis._

_Chaque classe n'a qu'une seule responsabilité : par exemple, la classe ConwayGameArguments ne s'occupe que des arguments fournis, et la classe ConwaySimulator a pour seule tâche de simuler le jeu de la vie de Conway ce qui montre une forte cohesion de chaque classe. Chaque classe est soit une sous-classe d'une classe abstraite, soit une implémentation d'une interface, ce qui permet d'ajouter de nouvelles fonctionnalités sans modifier les classes existantes._

_Enfin, l’interaction entre les classes est volontairement limitée : chaque classe communique uniquement avec celles dont elle dépend directement, et en utilisant un minimum d’informations. Cette faible dépendance favorise un couplage réduit, ce qui améliore la modularité et la réutilisabilité du code._

### Question 4: Évolution du code objet

_Notre conception du jeu de la vie de Conway permet effectivement de simuler le comportement de la fourmi de Langton. Dans ce jeu, une fourmi se déplace en fonction de la couleur de la case dans laquelle elle se trouve, qui est soit noire, soit blanche, puis change la couleur de la case après s'être déplacée.
Pour implémenter ce modèle, on peut créer une classe fille pour chaque classe mère du jeu de la vie (Cell, Board et GameArguments), avec une implémentation propre à la logique des fourmis de Langton, sans pour autant modifier les classes propres au jeu de Conway._

## Auto-évaluation (optionnelle)

Vous êtes libre de faire l'exercice de vous auto-évaluer en remplissant la grille d'évaluation du projet ci-dessous.

| Élement         | Critère d'évaluation                       | Note  |
| :---:           | :---                                       | :---: |
|  _Questions_    | (#1) Évolution du code légataire           | /5    |
|                 | (#2) Analyse des défauts du code légataire | /10   |
|                 | (#3) Justification des choix de conception | /15   |
|                 | (#4) Évolution du code objet               | /5    |
|  _Modèles_      | Justesse & Pertinence de la conception     | /15   |
|                 | Cohérence inter-modèles                    | /5    |
|                 | Respect des principes de conception        | /15   |
|  _Code_         | Qualité du code Java et du dépôt Git       | /10   |
|                 | Cohérence du code avec les modèles         | /10   | 
|                 | Qualité des tests                          | /10   |  
| **Note Finale** |                                            | /100  | 

_Cette auto-évaluation permet au correcteur de vous donner une rétro-action plus personnalisée en pointant les critères sur lesquels vous vous sur-évaluez et ceux sur lesquels au contraire vous vous sous-évaluez._
