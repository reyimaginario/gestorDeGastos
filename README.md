# gestorDeGastos
Gestor de gastos e ingresos para la administración financiera personal


## TODO
* MovimientoApi: (A futuro) Pensar si no es mejor mandar un ID en los Api en lugar de String
o un Api completo. (Cuando haya un front, se supone que estas categorias las saco de un dropbox
que ya tiene ID y DESC).
* Chequear que no vengan datos nulos: cuando se actualiza 'reques.getId()', el ID no puede ser null.
* Agregar servicios para el movimiento:     
    * Buscar movimientos por categoria y por multibles categorias
    * Buscar movimientos por fecha y rangos de fecha
    * Buscar movimientos por mes, por año