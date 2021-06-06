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

@Entity(name="habitacion")
public class Habitacion implements Serializable {

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
    private String tipohabitacion;
    @Column(nullable=false, length=100)
    private String caracteristicas;

    /** Default constructor. */
    public Habitacion() {
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
     * Access method for tipohabitacion.
     *
     * @return the current value of tipohabitacion
     */
    public String getTipohabitacion() {
        return tipohabitacion;
    }

    /**
     * Setter method for tipohabitacion.
     *
     * @param aTipohabitacion the new value for tipohabitacion
     */
    public void setTipohabitacion(String aTipohabitacion) {
        tipohabitacion = aTipohabitacion;
    }

    /**
     * Access method for caracteristicas.
     *
     * @return the current value of caracteristicas
     */
    public String getCaracteristicas() {
        return caracteristicas;
    }

    /**
     * Setter method for caracteristicas.
     *
     * @param aCaracteristicas the new value for caracteristicas
     */
    public void setCaracteristicas(String aCaracteristicas) {
        caracteristicas = aCaracteristicas;
    }

    /**
     * Compares the key for this instance with another Habitacion.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Habitacion and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Habitacion)) {
            return false;
        }
        Habitacion that = (Habitacion) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Habitacion.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Habitacion)) return false;
        return this.equalKeys(other) && ((Habitacion)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Habitacion |");
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
