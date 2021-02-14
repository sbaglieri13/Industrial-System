# Industrial System

## Introduzione
Consideriamo un sistema industriale la cui configurazione è un'aggregazione ricorsiva di Configuration Items.    
La configurazione fisica ha una rappresentazione digitale realizzata da un insieme di Digital Twin, ciascuno connesso ad un componente fisico.      
Gli elementi del sistema sono soggetti a fallimenti transienti (possono fallire e ripararsi), che vengono notificati ai rispettivi digital twins.      
Il metodo evaluate() offerto dal sistema valuta lo stato attuale di quest'ultimo e, a seconda della tipologia di Failure, avvia una strategia di risoluzione.

## Intento
Simulare un sistema industriale, valutarne le condizioni in uno specifico istante di tempo attraverso un metodo speciale offerto dal sistema
e avviare una strategia di risoluzione.

## Implementazione
Per implementare quanto descritto sopra utilizzamo 3 design pattern:  
- **Composite**: per la rappresentazione del sistema industriale, dove le Leaf sono Items elementari, e i Composite sono aggregazioni di Components;
- **Observer**: cosicché i digital twin ricevano notifica del cambiamento di stato del corrispondente componente fisico;
- **Strategy**: in modo tale da dare al sistema la possibilità di scegliere diverse strategie di risoluzione tra quelle a disposizione. Questi sono 
implementati come Singleton per risparmio di risorse, in quanto basta una sola istanza condivisa per ogni classe.

## Class Diagram
![ClassUMLIndustrialSystem](https://user-images.githubusercontent.com/39347210/107878471-3f0e7900-6ed3-11eb-98a9-2ec3a24dae76.png)

