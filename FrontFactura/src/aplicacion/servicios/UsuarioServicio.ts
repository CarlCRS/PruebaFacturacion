import { UsuarioApi } from "../../infraestructura/api/UsuarioApi"

export const UsuarioServicio = {
  async mayoresDe18() {
    return UsuarioApi.mayoresDe18()
  },

  async nombres() {
    return UsuarioApi.nombres()
  },

  async nombresOrdenados() {
    return UsuarioApi.nombresOrdenados()
  },

  async contarMayores() {
    return UsuarioApi.contarMayores()
  },
}
