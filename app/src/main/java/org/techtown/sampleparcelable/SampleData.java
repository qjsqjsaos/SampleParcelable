package org.techtown.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SampleData implements Parcelable {

    int number;
    String message;

    public SampleData(int num, String msg){
        number = num;
        message = msg;
    }

    public SampleData(Parcel src) { //Parcel 객체에서 읽기 여기서 Parcel이란 꾸러미를 뜻한다(클래스)
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { //이 객체는 반드시 상수로 정의되고 반드시 static final로
        //선언 되어야 한다. 그래서 CREATOR이란 상수를 정의 했다.

        public SampleData createFromParcel(Parcel in) {
            return new SampleData(in); //SampleData 생성자를 호출해 Parcel 객체에서 읽기
        }

        public SampleData[] newArray(int size) {
            return new SampleData[size];
        }


    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) { //Parcel 객체로 쓰기
        dest.writeInt(number);
        dest.writeString(message);
    }
}
//결과적으로 Sampledata 클래스 안에 Parcel 객체의 데이터를 읽는 부분과 쓰는 부분을 정의하게 된다.