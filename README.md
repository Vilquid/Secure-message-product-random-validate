# Lombok
Bibliothèque Java qui aide à créer :
- Les getters/setters
- Les constructeurs
- La méthode equals()
- La méthode toString()
# ID aléatoire
Identifiant unique universel (UUID) :
- Nombre unique de 128 bits utilisé pour identifier les informations dans les SI
- Autre nom : identificateur global unique (GUID)
Avantages :
- UUID universels
- Grande flexibilité si besoin de copier/fusionner des enregistrements
- Les UUID ne sont pas devinables
Inconvénients :
- Les performances peuvent être un problème
- Sa taille est 4 fois plus grande qu'un identifiant numérique et ne peut pas être géré aussi efficacement
- Certaines bases de données ne fonctionnent pas bien avec les UUID en tant qu’index
Il faut donc décider soigneusement si un UUID est plus utile qu’un identifiant numérique ou pas.
# DTO (Data Transfer Object)
Modèle de conception :
- Réduit le nombre d'appels lors d’un travail avec des interfaces
- Regroupe plusieurs appels à distance en un seul (performances en hausse)
Ex : API RESTful de compte bancaire
- Au lieu d'émettre plusieurs demandes pour vérifier le statut courant et les dernières transactions de notre compte, la banque pourrait exposer un endpoint qui renvoie un DTOrésumant toutID aléatoire, DTO et validation d'entrée.
Les DTO peuvent masquer les détails de mise en œuvre d’objets. L'exposition d'entités via des endpoints peut devenir un problème de sécurité si une bonne gestion de ceci n’est pas soigneusement observée.
Ex : API qui expose les détails de l'utilisateur et les mises à jour (requêtes GET pour demander/renvoyer les données utilisateur et requêtes PUT pour un Màj des détails)
Si cette application n'a pas tiré parti des DTO :
- Toutes les propriétés de l'utilisateur seraient exposées dans le premier endpoint
- Le 2ème endpoint devrait être très sélectif sur quelles propriétés accepter lors de la mise à jour d'un utilisateur (tout le monde ne peut pas mettre à jour les rôles d'un utilisateur)
Pour surmonter cette situation, les DTO peuvent être utiles en :
- Exposant uniquement ce à quoi le 1er endpoint est destiné à exposer
- Aidant le 2ème endpoint à restreindre ce qu'il accepte
Cette caractéristique nous aide à conserver l'intégrité des données dans nos applications.
