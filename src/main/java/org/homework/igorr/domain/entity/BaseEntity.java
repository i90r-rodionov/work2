package org.homework.igorr.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "custom")
    @GenericGenerator(name = "custom", parameters = @Parameter(name = "prefix", value = "prod"),
            strategy = "org.homework.igorr.domain.generator.SnowFlakeMock")
    @Column(name = "c_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "c_createdate", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "c_lastchangedate", nullable = false)
    @CreatedDate
    private LocalDateTime lastChangeDate;

    @Column(name = "c_version", nullable = false)
    @Version
    private Long version;

    @PrePersist
    void onCreate() {
        this.setCreateDate(LocalDateTime.now());
        this.setLastChangeDate(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate() {
        this.setLastChangeDate(LocalDateTime.now());
    }

    public boolean isPersisted() {
        return Objects.nonNull(id);
    }
}
