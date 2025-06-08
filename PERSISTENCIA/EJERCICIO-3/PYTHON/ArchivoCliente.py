import json
import os

class Cliente:
    def __init__(self, id, nombre, telefono):
        self.id = id
        self.nombre = nombre
        self.telefono = telefono

    def to_dict(self):
        return {
            "id": self.id,
            "nombre": self.nombre,
            "telefono": self.telefono
        }

    @staticmethod
    def from_dict(data):
        return Cliente(data["id"], data["nombre"], data["telefono"])

class ArchivoCliente:
    def __init__(self, nomA):
        self.nomA = nomA + ".json"

    def crear_archivo(self):
        if not os.path.exists(self.nomA):
            with open(self.nomA, 'w') as f:
                json.dump([], f)

    def guardar_cliente(self, cliente):
        with open(self.nomA, 'r') as f:
            datos = json.load(f)
        datos.append(cliente.to_dict())
        with open(self.nomA, 'w') as f:
            json.dump(datos, f)

    def buscar_cliente(self, c):
        with open(self.nomA, 'r') as f:
            datos = json.load(f)
        for item in datos:
            if item["id"] == c:
                return Cliente.from_dict(item)
        return None

    def buscar_celular_cliente(self, c):
        cliente = self.buscar_cliente(c)
        if cliente:
            return f"Nombre: {cliente.nombre}, Celular: {cliente.telefono}"
        return "Cliente no encontrado"

c1 = Cliente(1, "Ana Pérez", 77712345)
c2 = Cliente(2, "Luis García", 72145678)
c3 = Cliente(3, "Marta Rojas", 76543210)

archivo = ArchivoCliente("clientes")
archivo.crear_archivo()
archivo.guardar_cliente(c1)
archivo.guardar_cliente(c2)
archivo.guardar_cliente(c3)

res = archivo.buscar_cliente(2)
if res:
    print(res.nombre, res.telefono)
else:
    print("No encontrado")

print(archivo.buscar_celular_cliente(3))
