import { AutenticacionApi } from "../../infraestructura/api/AutenticacionApi"

export const AutenticacionServicio = {
  async login(data: any) {
    return AutenticacionApi.login(data)
  },

  async register(data: any) {
    return AutenticacionApi.register(data)
  },
}
