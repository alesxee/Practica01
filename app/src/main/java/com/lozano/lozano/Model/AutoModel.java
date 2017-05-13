package com.lozano.lozano.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ariso on 13/05/2017.
 */

public class AutoModel implements Parcelable {

    public static final String TABLE_NAME   ="auto";
    public static final String ID_FIELD     ="id";
    public static final String MARCA_FIELD  ="marca";
    public static final String PLACA_FIELD  ="placa";



    private Integer id;
    private String marca;
    private String placa;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    @Override
    public String toString() {
        return "AutoModel{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", placa='" + placa + '\'' +
                '}';
    }



    //METODOS DE PARCERABLE
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.marca);
        dest.writeString(this.placa);
    }

    public AutoModel() {
    }

    protected AutoModel(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.marca = in.readString();
        this.placa = in.readString();
    }

    public static final Parcelable.Creator<AutoModel> CREATOR = new Parcelable.Creator<AutoModel>() {
        @Override
        public AutoModel createFromParcel(Parcel source) {
            return new AutoModel(source);
        }

        @Override
        public AutoModel[] newArray(int size) {
            return new AutoModel[size];
        }
    };
}
