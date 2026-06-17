import { api } from "../config/conexion"

export const AutenticacionApi = {
  async login(data: any) {
    const response = await api.post("/auth/login", data)
    return response.data
  },

  async register(data: any) {
    await api.post("/auth/register", data)
  },
}
