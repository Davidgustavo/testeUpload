package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela DATAHORA
 * @generated
 */
@Entity
@Table(name = "\"DATAHORA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.DataHora")
public class DataHora implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Temporal(TemporalType.TIME)
  @Column(name = "item_hora", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date item_hora;

  /**
  * @generated
  */
  @Temporal(TemporalType.DATE)
  @Column(name = "item_data", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date item_data;

  /**
   * Construtor
   * @generated
   */
  public DataHora(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public DataHora setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém item_hora
   * return item_hora
   * @generated
   */
  
  public java.util.Date getItem_hora(){
    return this.item_hora;
  }

  /**
   * Define item_hora
   * @param item_hora item_hora
   * @generated
   */
  public DataHora setItem_hora(java.util.Date item_hora){
    this.item_hora = item_hora;
    return this;
  }

  /**
   * Obtém item_data
   * return item_data
   * @generated
   */
  
  public java.util.Date getItem_data(){
    return this.item_data;
  }

  /**
   * Define item_data
   * @param item_data item_data
   * @generated
   */
  public DataHora setItem_data(java.util.Date item_data){
    this.item_data = item_data;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    DataHora object = (DataHora)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
