
class HabitacionReserva(
    val id: Int,
    val clienteId: Int,
    val clienteNombre: String,
    val clienteCorreo: String,
    val cuartoNumero: Int,
    val cuartoTipo: String,
    val precioNoche: Double,
    val noches: Int
) {
    fun montoTotal() = precioNoche * noches
}
