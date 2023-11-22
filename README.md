**Work in progress**
El proceso para crear el Codificador César ha sido el siguiente:

Creamos la clase Codificador, la cual tiene tres atributos: 
    - El string textoOriginal, donde se almacena el string a codificar
    - Un array de char que contiene el alfabeto en minúsculas
    - Otro array de char que contiene el alfabeto en mayúsculas

Codificador tiene dos constructores: 
    - Uno que no recibe argumentos e inicializa textoOriginal como ""
    - Otro que recibe un string y lo almacena en textoOriginal

La clase tiene un getter y un setter para textoOriginal y otros dos métodos llamados "codificaDecodifica" y "cambio".

codificaDecodifica: 
    Recibe un int "iLlave" el cual es el número de posiciones que va a avanzar o retroceder cada carácter de mi string

    Primero que nada, declaramos tres variables: 
        - textArr es el String textoOriginal pero convertido a un array para poder iterarlo, esto lo conseguimos usando el método .toCharArray
        - La segunda variable es un array de char llamado alf, el cual va a ser asignado a alfabeto o alfabetoMayus más tarde para hacer el cambio depende de si la letra en la que nos encontramos en mayúscula o minúscula
        - La tercera variable es un int "index", el cual va a ser muy útil más tarde

    Con un bucle for, identificamos y modificamos los numeros de textArr en caso de que tenga, comprobando si se han salido del rango 48-57 (0-9 en ascii) y incrementandolo tantas veces como pida iLlave

    Usando otro bucle for, formateamos iLlave para evitar que sea un número muy grande, de ésta manera, siempre y cuando recibamos por parámetro un número mayor a la longitud de el array alfabeto, le restaremos ésta longitud, y cuando recibamos un número menor a 0, le sumaremos la longitud de alfabeto
    Con esto conseguimos que siempre que iLlave se pase de la longitud, vuelva al principio, o si se queda corta, vuelva al final del array, dejándo así un número más pequeño con el cual es más fácil trabajar

    Por ejemplo: la longitud de el array alfabeto es de 26(0-25), si nos pasan iLlave=27, nos conviene redefinirlo a iLlave=1. Si nos pasan iLlave=-1, nos conviene redefinirlo a iLlave=25. Con iLlave ya formateado, podemos empezar a hacer la codificación

    Usamos un doble bucle for, con el primero iteramos por cada letra de textArr, y por cada una la comparamos con cada letra de alfabeto o alfabetoMayus usando un if-else if en el segundo bucle for
    En caso de que el if-else if sea cierto, y por lo tanto, la letra en la que nos encontramos de textArr sea igual a la de alfabeto o alfabetoMayus, intentamos el cambio. Pero no lo hacemos dentro del propio bucle for, ya que eso podría resultar en un error que rompa el programa. El cambio lo intentamos en el segundo método de la clase, "cambio".

    Dicho método recibe 4 parámetros:
        - El array textArr
        - El array alf, ya asignado a mayúsculas o minúsculas dependiendo de la letra
        - Un int i, el cual es la posición en la que nos encontramos de textArr
        - El int index, el cual es la posición en la que me encuentro de alfabeto + iLlave
    
    El método "cambio" devuelve un boolean y contiene únicamente una estructura try-catch en la que intenta cambiar textArr[i] por alf[index]. Si falla, puede ser porque index exceda el rango de alfabeto, o porque se quede corto. 
    Para manejar esto, dentro del primer if de mis bucles for, tenemos otros dos if donde comprobamos que se pueda hacer el cambio: 
        - Si falla porque excede el rango, volvemos a intentarlo restándole a index la longitud de alf
        - Si falla porque se queda corto, volvemos a intentarlo sumándole a index la longitud de alf
    
    Una vez que el cambio está hecho, cortamos el segundo for con un break para evitar problemas y pasamos a la siguiente letra de textArr

    Al final, la función re-convierte textArr a un String ya codificado y lo devuelve

Tanto los atributos como el método "cambio" de la clase Codificador se declaran como private ya que solo deben ser accedidos desde la propia clase

En un archivo aparte, creamos una clase Main con un método main donde hemos creado un pequeño menú para ir pidiendo por teclado textos y llaves y probar a la perfección las funcionalidades de la clase Codificador
