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

##Intrucciones de uso
Para ejecutar el programa, se debe correr el archivo "App".

Con el programa abierto, se pueden añadir las expresiones que desee, utilizando la barra de selección ubicada en la parte superior de la ventana.
Dependiendo de lo que se desee agregar, ocurrirá lo siguiente:

* Si desea ingresar una operación (sea una dual o unaria), debe seleccionar el tipo de operación en la barra de selecciones.
Se desplegará un menú con todas las operaciones disponibles. Para agregar una, basta con clickear en el botón correspondiente a la operación.

* Si desea ingresar un tipo (entero, float, etc.), debe seleccionar "Type" en la barra de selección. Se desplegarán todos los tipos que se pueden ingresar.
Haga click en el tipo deseado y se desplegará una ventana, en la cuál debe anotar el valor que desee.

  Las ventanas son distintas dependiendo del tipo a ingresar. Los números poseen teclados, en los cuáles debe clickear en los números, como si fuese una calculadora. 
Para strings, sencillamente se escribe lo que desea y en bool se selecciona entre true y false con los botones de la ventana.

  En caso de cancelar el ingreso del tipo, basta con cerrar la ventana. Si desea ingresar al árbol el valor escrito, debe presionar el botón confirm.

El árbol se irá rellenando de izquierda a derecha, es decir, un nuevo elemento será incluído en el nodo disponible más a la izquierda posible, y si se encuentra ocupado por un Type, se ocupa el nodo derecho.
Si un árbol posee todas sus hojas llenas con Types, **no se podrá seguir agregando nuevas expresiones.**

Para limpiar el árbol, basta presionar el botón clear y para evaluar el resultado, el botón Eval. Este último abrirá una nueva ventana con el resultado.

La representación del árbol es en pseudocódigo.


## Consideraciones
Se realizan los siguientes supuestos de entradas al programa:
* Los números binarios reciben strings de largo a lo más 32 y con solo 0's y 1's. 
  Largos mayores provocarán que el programa no funcione correctamente.
* Las operaciones y transformaciones no son necesariamente bidireccionales, es decir que algunos tipos operan con la derecha con otros tipos
pero no se pueden operar por la izquierda con estos mismos.
* Se asumen que las entradas a los constructores de las clases son correctos.

Se especifican los siguientes tests para cada clase:

* SString --> SStringTest
* SBool --> SBoolTest
* SInt --> SIntTest
* SFloat --> SFloatTest
* SBinary --> SBinaryTest


* ConsString --> ConsStringTest
* ConsBool --> ConsBoolTest
* ConsInt --> ConsIntTest
* ConsFloat --> ConsFloatTest
* ConsBinary --> ConsBinaryTest


* Add --> AddTest
* Sub --> SubTest
* Times --> TimesTest
* Divide --> DivideTest
* Or --> OrTest
* And --> AndTest


* ToString --> ToStringTest
* ToInt --> ToIntTest
* ToFloat --> ToFloatTest
* ToBinary --> ToBinaryTest
* ToBool --> ToBoolTest
* Negate --> NegateTest


* SBinaryFactory --> SBinaryFactoryTest
* SIntFactory --> SIntFactoryTest
* SStringFactory --> SStringFactoryTest
* SFloatFactory --> SFloatFactoryTest
* SBoolFactory --> SBoolFactoryTest


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
  

Las clases "ConsType" corresponden a adapters permiten realizar todo tipo de operaciones, donde las operaciones inválidas retornarán NullConstant.
Implementan una interfaz con todas las operaciones posibles y por defecto retornarán NullConstant, redefiniendo tales operaciones de manera interna.


Luego, para crear AST's y evaluarlos, es importante verificar si las operaciones que se quieran realizar son válidas, según lo descrito más arriba,
y así evitar que retornen Null.

Con respecto a la clase NullConstant, se cumplen los siguientes puntos:
* Solo puede operar con las clases "ConsType".
* Cualquier operación con esta clase retorna NullConstant.
* Es una única instancia.
* Operaciones inválidas entre ConsTypes retornan NullConstant.

Con respecto a los factories, se cumplen las siguientes suposiciones:
* Cada una posee diccionario propio y cada factory cumple con crear un SType en específico.
* Las factories **no crean** adapters, al revés, los adapters utilizan las factories para almacenar cada uno su propio SType.
* Cada factory entrega una misma instancia.
