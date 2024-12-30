function validarIBAN(iban) {
    // Eliminar espacios en blanco y convertir a mayúsculas
    iban = iban.replace(/\s/g, '').toUpperCase();
    console.log('IBAN sin espacios y en mayúsculas:', iban);

    // Mover los primeros cuatro caracteres al final
    const rearrangedIban = iban.slice(4) + iban.slice(0, 4);
    console.log('IBAN reordenado:', rearrangedIban);

    // Convertir letras a números
    let numericIban = '';
    for (let i = 0; i < rearrangedIban.length; i++) {
        let char = rearrangedIban.charAt(i);
        if (char >= 'A' && char <= 'Z') {
            numericIban += (char.charCodeAt(0) - 55).toString(); // A=10, B=11, ..., Z=35
        } else {
            numericIban += char;
        }
    }
    console.log('IBAN numérico:', numericIban);

    // Calcular el módulo 97
    const remainder = BigInt(numericIban) % 97n;
    console.log('Resto del módulo 97:', remainder);
    
    return remainder === 1n;
}

// Ejemplo de uso
const iban = 'ES9121000418450200051332'; // Ejemplo de IBAN español
if (validarIBAN(iban)) {
    console.log('El IBAN es válido.');
} else {
    console.log('El IBAN no es válido.');
}
