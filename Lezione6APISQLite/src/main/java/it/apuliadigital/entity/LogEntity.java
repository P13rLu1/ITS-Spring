package it.apuliadigital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class LogEntity {

    @Id
    private String id;
    private String path;
    private String message;

    public LogEntity() {
    }

    public LogEntity(String id, String path, String message) {
        this.id = id;
        this.path = path;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity logEntity = (LogEntity) o;
        return Objects.equals(id, logEntity.id) && Objects.equals(path, logEntity.path) && Objects.equals(message, logEntity.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, message);
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}