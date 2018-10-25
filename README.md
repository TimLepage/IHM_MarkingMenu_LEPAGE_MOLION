# IHM_MarkingMenu_LEPAGE_MOLION

Choix d'implémentation:
La séléction d'un élément du menu se fait par survol avec la souris, permettant d'être très rapide pour un utilisateur expert mais aussi cela rend le menu plus propice aux "missclicks" pour un utilisateur débutant.
Les menus sont limités à 7 éléments, au delà de ce nombre, les éléments sont affichés en dessous du menu, entre les deux éléments du menu circulaire à 7 éléments. En revanche comme nous avons choisi de faire la séléction des éléments au survol de la souris, ces éléments ne sont pas accessibles (car on doit survoler d'autres éléments forcément pour les atteindre). Ce prblème pourrait être corrigé en utilisant le MousePressed et MouseReleased au lieu du MouseEntered pour gerer le menu.
Comme ce Marking Menu est conçu de manière très générique il peut être utilisé pour tous types d'application. Le dessin disparait lorsque le menu apparait pour faciliter la lecture du menu dans le cas ou l'application rendrait cette lecture confuse. Nous estimons que le fait que le dessin disparaisse n'est pas dérangeant outre mesure dans le cas d'applications simples comme celle ci (dessin).
 
