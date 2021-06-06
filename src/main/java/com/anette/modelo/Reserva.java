// Generated with g9.

package com.anette.modelo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="reserva")
public class Reserva implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/** Primary key. */
    protected static final String PK = "id";

   

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false, length=30)
    private String idhabitacion;
    @Column(nullable=false, length=10)
    private String fechaEntrada;
    @Column(nullable=false, length=10)
    private String fechaSalida;
    @ManyToOne(optional=false)
    @JoinColumn(name="idcliente", nullable=false)
    private Cliente cliente;

    /** Default constructor. */
    public Reserva() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for idhabitacion.
     *
     * @return the current value of idhabitacion
     */
    public String getIdhabitacion() {
        return idhabitacion;
    }

    /**
     * Setter method for idhabitacion.
     *
     * @param aIdhabitacion the new value for idhabitacion
     */
    public void setIdhabitacion(String aIdhabitacion) {
        idhabitacion = aIdhabitacion;
    }

    /**
     * Access method for fechaEntrada.
     *
     * @return the current value of fechaEntrada
     */
    public String getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Setter method for fechaEntrada.
     *
     * @param aFechaEntrada the new value for fechaEntrada
     */
    public void setFechaEntrada(String aFechaEntrada) {
        fechaEntrada = aFechaEntrada;
    }

    /**
     * Access method for fechaSalida.
     *
     * @return the current value of fechaSalida
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Setter method for fechaSalida.
     *
     * @param aFechaSalida the new value for fechaSalida
     */
    public void setFechaSalida(String aFechaSalida) {
        fechaSalida = aFechaSalida;
    }

    /**
     * Access method for cliente.
     *
     * @return the current value of cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Setter method for cliente.
     *
     * @param aCliente the new value for cliente
     */
    public void setCliente(Cliente aCliente) {
        cliente = aCliente;
    }

    /**
     * Compares the key for this instance with another Reserva.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Reserva and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Reserva)) {
            return false;
        }
        Reserva that = (Reserva) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Reserva.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Reserva)) return false;
        return this.equalKeys(other) && ((Reserva)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Reserva |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
