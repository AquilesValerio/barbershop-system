package com.barbershop.barbershop.api.validator;

import com.barbershop.barbershop.api.exceptions.services.BadRequestException;

public class PhoneValidator {

    public static String validatePhone(String phone) {

        if (phone == null || phone.isBlank()) {
            throw new BadRequestException("Telefone é obrigatório.");
        }

        // 1. Remover tudo que não é número
        String cleanPhone = phone.replaceAll("\\D", "");

        // 2. Verificar tamanho (11 dígitos no Brasil)
        if (cleanPhone.length() != 11) {
            throw new BadRequestException("Telefone inválido. Deve conter 11 dígitos.");
        }

        // 3. Regex para validar padrão brasileiro (DDD + 9 dígitos começando com 9)
        if (!cleanPhone.matches("^\\d{2}9\\d{8}$")) {
            throw new BadRequestException("Telefone inválido. Formato incorreto.");
        }

        // 4. Retorna o telefone limpo e validado
        return cleanPhone;
    }

}
