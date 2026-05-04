package com.rednorte.sigle.citas_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paciente_correo")
    private String pacienteCorreo; 

    @Column(name = "lista_espera_id")
    private Long listaEsperaId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;
    
    private String especialidad;
    
    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;
    
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;
}
