// Generated with g9.

package com.anette.modelo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="cliente")
public class Cliente implements Serializable {

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
    @Column(nullable=false, length=20)
    private String nombreusuario;
    @Column(nullable=false, length=30)
    private String correo;
    @Column(nullable=false, length=20)
    private String nombrecli;
    @Column(nullable=false, length=30)
    private String apellidopat;
    @Column(nullable=false, length=30)
    private String apellidomat;
    @Column(nullable=false, length=100)
    private String direccion;
    @Column(nullable=false, length=6)
    private String codigopostal;
    @Column(nullable=false, precision=10)
    private int edad;
    @Column(nullable=false, length=15)
    private String telefono;
    @Column(nullable=false, length=20)
    private byte[] claveacceso;
    @OneToMany(mappedBy="cliente")
    private Set<Reserva> reserva;

    /** Default constructor. */
    public Cliente() {
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
     * Access method for nombreusuario.
     *
     * @return the current value of nombreusuario
     */
    public String getNombreusuario() {
        return nombreusuario;
    }

    /**
     * Setter method for nombreusuario.
     *
     * @param aNombreusuario the new value for nombreusuario
     */
    public void setNombreusuario(String aNombreusuario) {
        nombreusuario = aNombreusuario;
    }

    /**
     * Access method for correo.
     *
     * @return the current value of correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Setter method for correo.
     *
     * @param aCorreo the new value for correo
     */
    public void setCorreo(String aCorreo) {
        correo = aCorreo;
    }

    /**
     * Access method for nombrecli.
     *
     * @return the current value of nombrecli
     */
    public String getNombrecli() {
        return nombrecli;
    }

    /**
     * Setter method for nombrecli.
     *
     * @param aNombrecli the new value for nombrecli
     */
    public void setNombrecli(String aNombrecli) {
        nombrecli = aNombrecli;
    }

    /**
     * Access method for apellidopat.
     *
     * @return the current value of apellidopat
     */
    public String getApellidopat() {
        return apellidopat;
    }

    /**
     * Setter method for apellidopat.
     *
     * @param aApellidopat the new value for apellidopat
     */
    public void setApellidopat(String aApellidopat) {
        apellidopat = aApellidopat;
    }

    /**
     * Access method for apellidomat.
     *
     * @return the current value of apellidomat
     */
    public String getApellidomat() {
        return apellidomat;
    }

    /**
     * Setter method for apellidomat.
     *
     * @param aApellidomat the new value for apellidomat
     */
    public void setApellidomat(String aApellidomat) {
        apellidomat = aApellidomat;
    }

    /**
     * Access method for direccion.
     *
     * @return the current value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter method for direccion.
     *
     * @param aDireccion the new value for direccion
     */
    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

    /**
     * Access method for codigopostal.
     *
     * @return the current value of codigopostal
     */
    public String getCodigopostal() {
        return codigopostal;
    }

    /**
     * Setter method for codigopostal.
     *
     * @param aCodigopostal the new value for codigopostal
     */
    public void setCodigopostal(String aCodigopostal) {
        codigopostal = aCodigopostal;
    }

    /**
     * Access method for edad.
     *
     * @return the current value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter method for edad.
     *
     * @param aEdad the new value for edad
     */
    public void setEdad(int aEdad) {
        edad = aEdad;
    }

    /**
     * Access method for telefono.
     *
     * @return the current value of telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter method for telefono.
     *
     * @param aTelefono the new value for telefono
     */
    public void setTelefono(String aTelefono) {
        telefono = aTelefono;
    }

    /**
     * Access method for claveacceso.
     *
     * @return the current value of claveacceso
     */
    public byte[] getClaveacceso() {
        return claveacceso;
    }

    /**
     * Setter method for claveacceso.
     *
     * @param aClaveacceso the new value for claveacceso
     */
    public void setClaveacceso(byte[] aClaveacceso) {
        claveacceso = aClaveacceso;
    }

    /**
     * Access method for reserva.
     *
     * @return the current value of reserva
     */
    public Set<Reserva> getReserva() {
        return reserva;
    }

    /**
     * Setter method for reserva.
     *
     * @param aReserva the new value for reserva
     */
    public void setReserva(Set<Reserva> aReserva) {
        reserva = aReserva;
    }

    /**
     * Compares the key for this instance with another Cliente.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Cliente and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Cliente)) {
            return false;
        }
        Cliente that = (Cliente) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Cliente.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cliente)) return false;
        return this.equalKeys(other) && ((Cliente)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Cliente |");
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
