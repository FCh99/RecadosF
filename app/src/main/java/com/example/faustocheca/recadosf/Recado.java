package com.example.faustocheca.recadosf;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by faustocheca on 12/9/16.
 */
public class Recado implements Parcelable {

    Date fecha_hora_Rec;
    String nombre_cliente_Rec;
    String telefono_Rec;
    String direccion_recogida_Rec;
    String direccion_entrega_Rec;
    String descripcion_Rec;
    Date fecha_hora_max_Rec;

    public Recado(Date fecha_hora_Rec, String nombre_cliente_Rec, String telefono_Rec, String direccion_recogida_Rec, String direccion_entrega_Rec, String descripcion_Rec, Date fecha_hora_max_Rec) {
        this.fecha_hora_Rec = fecha_hora_Rec;
        this.nombre_cliente_Rec = nombre_cliente_Rec;
        this.telefono_Rec = telefono_Rec;
        this.direccion_recogida_Rec = direccion_recogida_Rec;
        this.direccion_entrega_Rec = direccion_entrega_Rec;
        this.descripcion_Rec = descripcion_Rec;
        this.fecha_hora_max_Rec = fecha_hora_max_Rec;
    }


    protected Recado(Parcel in) {
        nombre_cliente_Rec = in.readString();
        telefono_Rec = in.readString();
        direccion_recogida_Rec = in.readString();
        direccion_entrega_Rec = in.readString();
        descripcion_Rec = in.readString();
    }

    public static final Creator<Recado> CREATOR = new Creator<Recado>() {
        @Override
        public Recado createFromParcel(Parcel in) {
            return new Recado(in);
        }

        @Override
        public Recado[] newArray(int size) {
            return new Recado[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre_cliente_Rec);
        parcel.writeString(telefono_Rec);
        parcel.writeString(direccion_recogida_Rec);
        parcel.writeString(direccion_entrega_Rec);
        parcel.writeString(descripcion_Rec);
    }

    public Date getFecha_hora_Rec() {
        return fecha_hora_Rec;
    }

    public String getNombre_cliente_Rec() {
        return nombre_cliente_Rec;
    }

    public String getTelefono_Rec() {
        return telefono_Rec;
    }

    public String getDireccion_recogida_Rec() {
        return direccion_recogida_Rec;
    }

    public String getDireccion_entrega_Rec() {
        return direccion_entrega_Rec;
    }

    public String getDescripcion_Rec() {
        return descripcion_Rec;
    }

    public Date getFecha_hora_max_Rec() {
        return fecha_hora_max_Rec;
    }

    public static Creator<Recado> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "Recado{" +
                "fecha_hora_Rec=" + fecha_hora_Rec +
                ", nombre_cliente_Rec='" + nombre_cliente_Rec + '\'' +
                ", telefono_Rec='" + telefono_Rec + '\'' +
                ", direccion_recogida_Rec='" + direccion_recogida_Rec + '\'' +
                ", direccion_entrega_Rec='" + direccion_entrega_Rec + '\'' +
                ", descripcion_Rec='" + descripcion_Rec + '\'' +
                ", fecha_hora_max_Rec=" + fecha_hora_max_Rec +
                '}';
    }
}
