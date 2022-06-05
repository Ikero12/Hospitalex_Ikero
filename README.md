# Hospitalex Ikero

Aplicacion de gestion hospitalaria que funciona con una base de datos SQLite.

![Hospitalex_Ikero](https://icon-library.com/images/hospital-cross-icon/hospital-cross-icon-20.jpg)

## Instalación

Descargalo, abrelo con un IDE compatible con Gradle y listo!

Este programa funciona gracias a las librerías:

- ###[sqlite-jdbc](https://github.com/xerial/sqlite-jdbc):

    - Gradle:
```bash
 implementation 'org.xerial:sqlite-jdbc:3.36.0.2'
```

- ###[bcrypt](https://github.com/patrickfav/bcrypt):

    - Gradle:
```bash
implementation "org.mindrot:jbcrypt:0.4"
```

## Características

- Inicia sesión como médico, enfermero o paciente.
- Como paciente, revisa tus citas e ingresos.
- Como médico, revisa tus citas, añade pacientes y busca los datos medicos de un paciente.
- Como enfermero, revisa que pacientes están ingresados en tu planta y busca los datos medicos de un paciente concreto. 
- Cambio de contraseña con cualquier cuenta.
- Las contraseñas se almacenan hashed con Bcrypt para una capa extra de seguridad.

## FAQ

#### Como funciona el inicio de sesión?

El nombre de usuario es el DNI de la persona. El selector de arriba te dejará elegir en que tipo de cuenta deseas iniciar sesión (ya que un médico o enfermero también puede ser paciente). 
Por último, destacar el botón de "Recordarme", que sirve para que tu sesión quede guardada.
#### Como se buscan Pacientes?

En la interfaz de medico y enfermero existe un campo de texto donde introducir el DNI del paciente. Una vez introducido el DNI deseado solo se debera pulsar "enter" para iniciar la búsqueda.

#### Como enfermero, que pacientes veo?

Los pacientes que te aparezcan en la tabla de ingresos serán aquellos que estén ingresados en tu planta designada. Si necesitas los datos de algún otro paciente, búsquelo por su DNI en el buscador.

