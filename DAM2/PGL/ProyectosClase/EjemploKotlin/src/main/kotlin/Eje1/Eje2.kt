import java.util.Scanner

fun main() {
    print("Introduzca un número cualquiera: ");
    var numero = getNumber2();
    showResult2(numero);
}

fun getNumber2(): Int {
    val reader = Scanner(System.`in`);
    return reader.nextInt();
}

fun showResult2(numero: Int) {
    print("La suma de los números desde 1 hasta " + numero + " es ");
    var sum = 0;
    for (i in 1..numero) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    print(sum);
}