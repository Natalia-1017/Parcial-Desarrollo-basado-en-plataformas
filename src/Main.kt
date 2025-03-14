
import java.util.Scanner

fun main() {
    val gestor = GestorReservas()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nReservas hotel Sol y Luna:")
        println("1. Registrar una reserva")
        println("2. Cancelar una reserva")
        println("3. Mostrar todas las reservas activas")
        println("4. Mostrar tipos de habitaciones disponibles")
        println("5. Mostrar habitaciones más baratas y más caras")
        println("6. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> {
                gestor.mostrarHabitacionesDisponibles()
                println("Registrar una nueva reserva:")
                print("ID de la reserva: ")
                val id = scanner.nextInt()
                print("ID del huésped: ")
                val clienteId = scanner.nextInt()
                scanner.nextLine()
                print("Nombre del huésped: ")
                val clienteNombre = scanner.nextLine()
                print("Email del huésped: ")
                val clienteCorreo = scanner.nextLine()
                print("Número de habitación: ")
                val cuartoNumero = scanner.nextInt()
                scanner.nextLine()
                print("Tipo de habitación: ")
                val cuartoTipo = scanner.nextLine()
                print("Precio por noche: ")
                val precioNoche = scanner.nextDouble()
                print("Cantidad de noches reservadas: ")
                val noches = scanner.nextInt()

                val reserva = HabitacionReserva(id, clienteId, clienteNombre, clienteCorreo, cuartoNumero, cuartoTipo, precioNoche, noches)
                gestor.registrarReserva(reserva)
            }
            2 -> {
                print("ID de la reserva, que deseas cancelar: ")
                val id = scanner.nextInt()
                gestor.cancelarReserva(id)
            }
            3 -> {
                gestor.mostrarReservasActivas()
            }
            4 -> {
                gestor.mostrarHabitacionesDisponibles()
            }
            5 -> {
                gestor.mostrarHabitacionesMasBaratasYCaras()
            }
            6 -> {
                println("Saliendo del sistema de reservas. ¡Hasta luego, esperamos que tu estadia en nuestro hotel sea satisfactoria!")
                return
            }
            else -> {
                println("Opción no válida. Intenta de nuevo, por favor.")
            }
        }
    }
}
