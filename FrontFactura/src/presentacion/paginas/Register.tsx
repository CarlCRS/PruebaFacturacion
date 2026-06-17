import { Button, Card, CardBody, Form } from "react-bootstrap"
import { useForm } from "react-hook-form"
import { useNavigate } from "react-router-dom"
import { AutenticacionServicio } from "../../aplicacion/servicios/AutenticacionServicio"

const Register = () => {
  const { register, handleSubmit, reset } = useForm()
  const navigate = useNavigate()

  const handleSubmitForm = async (data: any) => {
    localStorage.removeItem("token")
    try {
      await AutenticacionServicio.register(data)
      alert("Usuario registrado exitosamente")
      reset()
      navigate("/")
    } catch {
      alert("No se pudo registrar el usuario")
    }
  }

  return (
    <div className="container mt-5">
      <Card className="shadow p-4">
        <CardBody>
          <Button variant="outline-primary" href="/">Login</Button>
          <Form onSubmit={handleSubmit(handleSubmitForm)}>
            <h2>Registro de usuario</h2>
            <Form.Group>
              <Form.Label>Nombre</Form.Label>
              <Form.Control type="text" required {...register("nombre")} />
            </Form.Group> 
            <Form.Group>
              <Form.Label>Correo</Form.Label>
              <Form.Control type="email" required {...register("correo")} />
            </Form.Group>
            <Form.Group>
              <Form.Label>Contrasena</Form.Label>
              <Form.Control type="password" required {...register("password")} />
            </Form.Group>
            <Button className="mt-3" type="submit">Enviar</Button>
          </Form>
        </CardBody>
      </Card>
    </div>
  )
}

export default Register
