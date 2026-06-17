import { useForm } from "react-hook-form"
import { Button, Card, CardBody, Form } from "react-bootstrap"
import { Link, useNavigate } from "react-router-dom"
import { AutenticacionServicio } from "../../aplicacion/servicios/AutenticacionServicio"

const Login = () => {
  const { handleSubmit, register } = useForm()
  const navigate = useNavigate()

  const handleLogin = async (data: any) => {
    localStorage.removeItem("token")
    try {
      const response = await AutenticacionServicio.login(data)
      localStorage.setItem("token", response.token)
      navigate("/home")
    } catch {
      alert("Credenciales invalidas")
    }
  }

  return (
    <div className="container mt-5">
      <Card className="shadow p-4">
        <CardBody>
          <h2>Iniciar Sesion</h2>
          <Form onSubmit={handleSubmit(handleLogin)}>
            <Form.Group>
              <Form.Label>Correo</Form.Label>
              <Form.Control type="email" required {...register("correo")} />
            </Form.Group>
            <Form.Group>
              <Form.Label>Contrasena</Form.Label>
              <Form.Control type="password" required {...register("password")} />
            </Form.Group>
            <Button className="mt-3" type="submit" variant="outline-primary">Ingresar</Button>
            <span className="ms-2"> No tienes cuenta? <Link to="/registro">Registrate</Link></span>
          </Form>
        </CardBody>
      </Card>
    </div>
  )
}

export default Login
