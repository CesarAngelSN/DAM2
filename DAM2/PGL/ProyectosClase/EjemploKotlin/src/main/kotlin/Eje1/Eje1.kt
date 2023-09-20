import java.util.Scanner

fun main() {
    print("Introduzca un número cualquiera: ");
    var numero = getNumber();
    showResult(numero);
}

fun getNumber(): Int {
    val reader = Scanner(System.`in`);
    return reader.nextInt();
}

fun showResult(numero: Int) {
    print("La suma de los números desde 1 hasta " + numero + " es ");
    var sum = 0;
    for (i in 1..numero) {
        sum += i;
    }
    print(sum);
}