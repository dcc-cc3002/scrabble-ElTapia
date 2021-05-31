# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---
Se realizan los siguientes supuestos de entradas al programa:
* Los números binarios reciben strings de largo a lo más 32 y con solo 0's y 1's. 
  Largos mayores provocarán que el programa no funcione correctamente.
* Las operaciones or y and entre binarios deben realizarse para binarios del mismo tamaño.
* No se consideran iguales binarios con mismo valor entero pero con más 0's o 1's a la izquierda.
* Las operaciones y transformaciones no son necesariamente bidireccionales, es decir que algunos tipos operan con la derecha con otros tipos
pero no se pueden operar por la izquierda con estos mismos.
* Se asumen que las entradas a los constructores de las clases son correctos.

Se especifican los siguientes tests para cada clase:

* SString --> SStringTest
* SBool --> SBoolTest
* SInt --> SIntTest
* SFloat --> SFloatTest
* SBinary --> SBinaryTest

Las transformaciones que se pueden realizar quedan especificadas como sigue:
* String transforma a String.
* Bool transforma a String y Bool.
* Float transforma a String y Float.
* Int transforma a String, Float, Int y Binary.
* Binary transforma a String, Float, Int y Binary.

Por otro lado, los tipos pueden realizar las siguientes operaciones por la derecha:
* String suma con String, Bool, Float, Int y Binary.
* Bool conjunción y disyunción lógica con Bool y Binary.
* Float suma, resta, multiplica y divide con Float, Int y Binary.
* Int suma, resta, multiplica y divide con Float, Int y Binary.
* Binary suma, resta multiplica y divide con Int y Binary. Además de conjunción y disyunción lógica
con Bool y Binary