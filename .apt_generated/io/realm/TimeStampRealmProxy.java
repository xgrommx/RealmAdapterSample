package io.realm;


import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.examples.realmadapters.models.*;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.Row;
import io.realm.internal.Table;
import java.util.*;

public class TimeStampRealmProxy extends TimeStamp {

    @Override
    public int getRandom() {
        realm.assertThread();
        return (int) row.getLong(Realm.columnIndices.get("TimeStamp").get("random"));
    }

    @Override
    public void setRandom(int value) {
        realm.assertThread();
        row.setLong(Realm.columnIndices.get("TimeStamp").get("random"), (long) value);
    }

    @Override
    public String getTimeStamp() {
        realm.assertThread();
        return (java.lang.String) row.getString(Realm.columnIndices.get("TimeStamp").get("timeStamp"));
    }

    @Override
    public void setTimeStamp(String value) {
        realm.assertThread();
        row.setString(Realm.columnIndices.get("TimeStamp").get("timeStamp"), (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if(!transaction.hasTable("class_TimeStamp")) {
            Table table = transaction.getTable("class_TimeStamp");
            table.addColumn(ColumnType.INTEGER, "random");
            table.addColumn(ColumnType.STRING, "timeStamp");
            return table;
        }
        return transaction.getTable("class_TimeStamp");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if(transaction.hasTable("class_TimeStamp")) {
            Table table = transaction.getTable("class_TimeStamp");
            if(table.getColumnCount() != 2) {
                throw new IllegalStateException("Column count does not match");
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for(long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }
            if (!columnTypes.containsKey("random")) {
                throw new IllegalStateException("Missing column 'random'");
            }
            if (columnTypes.get("random") != ColumnType.INTEGER) {
                throw new IllegalStateException("Invalid type 'int' for column 'random'");
            }
            if (!columnTypes.containsKey("timeStamp")) {
                throw new IllegalStateException("Missing column 'timeStamp'");
            }
            if (columnTypes.get("timeStamp") != ColumnType.STRING) {
                throw new IllegalStateException("Invalid type 'String' for column 'timeStamp'");
            }
        }
    }

    public static List<String> getFieldNames() {
        return Arrays.asList("random", "timeStamp");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TimeStamp = [");
        stringBuilder.append("{random:");
        stringBuilder.append(getRandom());
        stringBuilder.append("} ");
        stringBuilder.append("{timeStamp:");
        stringBuilder.append(getTimeStamp());
        stringBuilder.append("} ");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getRandom();
        String aString_1 = getTimeStamp();
        result = 31 * result + (aString_1 != null ? aString_1.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeStampRealmProxy aTimeStamp = (TimeStampRealmProxy)o;
        if (getRandom() != aTimeStamp.getRandom()) return false;
        if (getTimeStamp() != null ? !getTimeStamp().equals(aTimeStamp.getTimeStamp()) : aTimeStamp.getTimeStamp() != null) return false;
        return true;
    }

}
