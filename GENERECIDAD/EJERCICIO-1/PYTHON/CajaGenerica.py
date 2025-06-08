class CajaGenerica:
    def __init__(self):
        self.caja = []

    def guardar(self, elemento):
        self.caja.append(elemento)

    def obtener(self):
        for i in range(len(self.caja)):
            print(self.caja[i])
c1 = CajaGenerica()
c1.guardar(10)
c1.guardar("hola")
c1.guardar(3.14)
c1.obtener()  

c1.guardar("mundo")
c1.obtener()  