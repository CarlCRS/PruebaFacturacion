import { ProductoApi } from "../../infraestructura/api/ProductoApi"

export const ProductoServicio = {
  async obtenerTodos() {
    return ProductoApi.obtenerTodos()
  },

  async obtenerPorId(id: number) {
    return ProductoApi.obtenerPorId(id)
  },

  async crear(data: any) {
    return ProductoApi.crear(data)
  },

  async actualizar(id: number, data: any) {
    return ProductoApi.actualizar(id, data)
  },

  async eliminar(id: number) {
    return ProductoApi.eliminar(id)
  },
}
