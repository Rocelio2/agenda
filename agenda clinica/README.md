# NOVA Clínica — MVP de gestión de citas

Aplicación con React + Vite, Spring Boot 3.5 / Java 17 y SQL Server.

## Incluye
- Panel administrativo protegido con HTTP Basic.
- Agenda por rango de fechas, búsqueda y cambio de estado de citas.
- Directorio de pacientes y listado de profesionales.
- Formulario público de solicitud de citas, sin cuenta de paciente.
- Duración manual (fecha/hora de inicio y fin).
- Validación de intervalos: impide cruces para el mismo paciente o médico; las citas canceladas no bloquean horarios.
- Validación de fechas pasadas, rangos inválidos, médicos inactivos y errores HTTP centralizados.

## Inicio
1. Ejecutar `agenda-contactos-backend/agenda-contactos-backend/crear-base-de-datos.sql` en SSMS conectado a `SQLEXPRESS`.
2. Configurar credenciales en `application.properties` o variables `DB_URL`, `DB_USER`, `DB_PASSWORD`, `APP_ADMIN_USER`, `APP_ADMIN_PASSWORD`.
3. Backend: entrar a `agenda-contactos-backend/agenda-contactos-backend` y ejecutar `mvnw.cmd spring-boot:run` (Windows).
4. Frontend: entrar a `agenda-contactos-frontend`, ejecutar `npm install` y `npm run dev`.
5. Abrir la URL de Vite (normalmente `http://localhost:5173`).

## Acceso inicial
- Usuario: `admin`
- Contraseña: `CambiarAdmin2026!`

Cambiar la contraseña antes de utilizarlo fuera del entorno local. El acceso administrativo utiliza HTTP Basic sobre HTTPS en despliegue; en local Vite/Spring se comunican por proxy. Las reservas públicas son solicitudes, no confirmaciones automáticas.

## API principal
- `GET /api/public/medicos`, `GET /api/public/especialidades`
- `POST /api/public/citas`
- `GET /api/admin/citas?desde=YYYY-MM-DD&hasta=YYYY-MM-DD`
- `PATCH /api/admin/citas/{id}/estado`
- `GET /api/admin/pacientes`

## Nota de MVP
La disponibilidad de citas se valida en el servicio y con bloqueos pesimistas sobre médico/paciente durante la transacción. Antes de producción deben añadirse pruebas de concurrencia sobre SQL Server, horarios/ausencias de médicos, recuperación de contraseña, auditoría, consentimiento y políticas de privacidad de datos médicos. El MVP no registra diagnósticos ni historias clínicas detalladas.
