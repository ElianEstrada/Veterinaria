USE veterinaria;

INSERT INTO
    Tipo_Usuario ( nombre )
VALUES
    ('Administrador'),
    ('Cliente');

INSERT INTO
    Tipo_Producto ( nombre )
VALUES
    ('Comida'),
    ('Juguetes'),
    ('Medicina')
    ;

SELECT *
FROM
    Tipo_Usuario;

SELECT *
FROM
    Usuario;

SELECT *
FROM
    Cita;

SELECT *
FROM
    Factura;

SELECT *
FROM
    Tipo_Producto;

SELECT *
FROM
    Producto;

SELECT *
FROM
    Detalle_Producto;
