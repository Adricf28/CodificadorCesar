var textoOriginal = document.getElementById("message");

//console.log("textoOriginal: " + textoOriginal.value);
alert(textoOriginal);

function isDigit(c) {
    return c >= '0' && c <= '9';
}

function codificaDecodifica(iLlave, text) {
    var alfabeto = 'abcdefghijklmnopqrstuvwxyz';
    var alfabetoMayus = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

    function ajustarIndice(index, length) {
        while (index > length - 1) {
            index -= length;
        }
        while (index < 0) {
            index += length;
        }
        return index;
    }

    var resultado = '';

    for (var i = 0; i < text.length; i++) {
        if (isDigit(text[i])) {
            var index = parseInt(text[i]) + iLlave;
            resultado += ajustarIndice(index, 10);
        } else if ((alfabeto + alfabetoMayus).includes(text[i])) {
            var alf = alfabeto.includes(text[i]) ? alfabeto : alfabetoMayus;
            var index = alf.indexOf(text[i]) + iLlave;
            resultado += alf.charAt(ajustarIndice(index, alf.length));
        } else {
            resultado += text[i];
        }
    }

    return resultado;
}