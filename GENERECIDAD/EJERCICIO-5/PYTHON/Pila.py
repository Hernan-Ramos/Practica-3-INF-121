class Pila:
    def __init__(self):
        self._elementos = []

    def push(self, elemento):
        self._elementos.append(elemento)

    def pop(self):
        return self._elementos.pop()

    def peek(self):
        return self._elementos[-1]

    def esta_vacia(self):
        return len(self._elementos)==0


p1 = Pila()
p1.push(10)
p1.push(20)
print(p1.pop()) 

p2 = Pila()
p2.push("hola")
p2.push("mundo")
print(p2.pop())