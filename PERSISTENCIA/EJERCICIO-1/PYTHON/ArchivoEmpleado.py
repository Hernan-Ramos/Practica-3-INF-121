import json
import os

class Empleado:
    def __init__(self, nombre, edad, salario):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def to_dict(self):
        return {
            "nombre": self.nombre,
            "edad": self.edad,
            "salario": self.salario
        }

    @staticmethod
    def from_dict(data):
        return Empleado(data["nombre"], data["edad"], data["salario"])

class ArchivoEmpleado:
    def __init__(self, nomA):
        self.nomA = nomA + ".json"

    def crear_archivo(self):
        if not os.path.exists(self.nomA):
            with open(self.nomA, 'w') as f:
                json.dump([], f)

    def guardar_empleado(self, e):
        with open(self.nomA, 'r') as f:
            datos = json.load(f)
        datos.append(e.to_dict())
        with open(self.nomA, 'w') as f:
            json.dump(datos, f)

    def buscar_empleado(self, nombre_buscado):
        with open(self.nomA, 'r') as f:
            datos = json.load(f)
        for item in datos:
            if item["nombre"] == nombre_buscado:
                print("Empleado encontrado:")
                print("Nombre:", item["nombre"])
                print("Edad:", item["edad"])
                print("Salario:", item["salario"])
                return
        print("Empleado no encontrado.")

    def mayor_salario(self, s):
        with open(self.nomA, 'r') as f:
            datos = json.load(f)
        mayor = None
        for item in datos:
            if item["salario"] > s:
                if mayor is None or item["salario"] > mayor["salario"]:
                    mayor = item
        if mayor:
            print("Empleado con salario mayor que", s, ":")
            print("Nombre:", mayor["nombre"])
            print("Edad:", mayor["edad"])
            print("Salario:", mayor["salario"])
        else:
            print("No hay empleado con salario mayor a", s)

e1 = Empleado("Juan Perez", 30, 2500.0)
e2 = Empleado("Maria Lopez", 40, 3000.0)
e3 = Empleado("Carlos Diaz", 28, 2200.0)

arch = ArchivoEmpleado("empleados")
arch.crear_archivo()
arch.guardar_empleado(e1)
arch.guardar_empleado(e2)
arch.guardar_empleado(e3)

print()
arch.buscar_empleado("Maria Lopez")

print()
arch.mayor_salario(2600.0)
