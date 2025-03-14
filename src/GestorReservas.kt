

class GestorReservas {
    private val reservas = mutableListOf<HabitacionReserva>()
    private val habitaciones = listOf(
        Habitacion("Individual", 50000.0),
        Habitacion("Doble", 80000.0),
        Habitacion("Triple", 120000.0),
        Habitacion("Suite Junior", 150000.0),
        Habitacion("Suite", 200000.0),
        Habitacion("Suite Ejecutiva", 300000.0)
    )

    fun mostrarHabitacionesDisponibles() {
        println("Tipos de habitaciones disponibles en el hotel:")
        habitaciones.forEach {
            println("${it.tipo}: \$${it.precio} por noche")
        }
    }

    fun mostrarHabitacionesMasBaratasYCaras() {
        println("Habitaciones más baratas:")
        habitaciones.sortedBy { it.precio }.take(3).forEach {
            println("${it.tipo}: \$${it.precio} por noche")
        }
        println("\nHabitaciones más caras:")
        habitaciones.sortedByDescending { it.precio }.take(3).forEach {
            println("${it.tipo}: \$${it.precio} por noche")
        }
    }

    fun registrarReserva(reserva: HabitacionReserva): Boolean {
        if (reservas.any { it.cuartoNumero == reserva.cuartoNumero }) {
            println("Error: El cuarto ${reserva.cuartoNumero} ya está reservado, intenta reservar otro cuarto.")
            return false
        }
        reservas.add(reserva)
        println("Reserva registrada con éxito.")
        return true
    }

    fun cancelarReserva(id: Int): Boolean {
        val reserva = reservas.find { it.id == id }
        return if (reserva != null) {
            reservas.remove(reserva)
            println("Reserva con ID $id cancelada correctamente.")
            true
        } else {
            println("Error: No se encontró la reserva con ID $id.")
            false
        }
    }

    fun mostrarReservasActivas() {
        if (reservas.isEmpty()) {
            println("No hay reservas activas.")
        } else {
            println("Reservas activas:")
            reservas.forEach {
                println("ID: ${it.id}, Cliente: ${it.clienteNombre}, Cuarto: ${it.cuartoNumero}, Monto total: \$${it.montoTotal()}")
            }
        }
    }
}

class Habitacion(val tipo: String, val precio: Double)
