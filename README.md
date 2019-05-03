# Claves publicas/privadas
Explica el funcionamiento de las claves publicas y privadas usando el algoritmo RSA


### Caso 1

- A envia un mensaje encriptado con su clave privada a B y B lo desencripta con la clave publica de A.
- B puede confirmar que quien le envio el mensaje es A.
- El mensaje puede abrirlo cualquier persona que tenga el mensaje encriptado y la clave publica de A.


### Caso 2

- A envia un mensaje encriptado con la clave publica de B a B y B lo desencripta con su propia clave privada.
- B no puede confirmar quien le envio el mensaje.
- A se asegura de que solo B pueda leer el mensaje, ya que solo B tiene su clave privada.


### Caso 3

- A encripta un mensaje con su llave privada y lo vuelve a encriptar con la llave publica de B.
- A envia el mensaje a B
- B desencripta el mensaje con su llave privada asegurando que solo el lo pueda leer.
- B vuelve a desencriptar el mensaje usando la llave publica de A confirmando que A fue quien lo escribio.
