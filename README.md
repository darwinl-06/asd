
```
sequenceDiagram
    participant Cliente
    participant Servicio
    participant Cache
    participant BD

    Cliente->>Servicio: Solicita dato X
    Servicio->>Cache: Busca dato X
    Cache-->>Servicio: Miss (no encontrado)
    Servicio->>BD: Consulta dato X
    BD-->>Servicio: Responde dato X
    Servicio->>Cache: Guarda dato X
    Servicio-->>Cliente: Retorna dato X
```
 
 
