/*
 * This file is generated by jOOQ.
 */
package com.test_CTM.jooq.generated.tables;


import com.test_CTM.jooq.generated.Keys;
import com.test_CTM.jooq.generated.Public;
import com.test_CTM.jooq.generated.tables.Tickets.TicketsPath;
import com.test_CTM.jooq.generated.tables.records.CarriersRecord;

import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Carriers extends TableImpl<CarriersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.carriers</code>
     */
    public static final Carriers CARRIERS = new Carriers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CarriersRecord> getRecordType() {
        return CarriersRecord.class;
    }

    /**
     * The column <code>public.carriers.id</code>.
     */
    public final TableField<CarriersRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.carriers.phone</code>.
     */
    public final TableField<CarriersRecord, String> PHONE = createField(DSL.name("phone"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.carriers.name</code>.
     */
    public final TableField<CarriersRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100), this, "");

    private Carriers(Name alias, Table<CarriersRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Carriers(Name alias, Table<CarriersRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.carriers</code> table reference
     */
    public Carriers(String alias) {
        this(DSL.name(alias), CARRIERS);
    }

    /**
     * Create an aliased <code>public.carriers</code> table reference
     */
    public Carriers(Name alias) {
        this(alias, CARRIERS);
    }

    /**
     * Create a <code>public.carriers</code> table reference
     */
    public Carriers() {
        this(DSL.name("carriers"), null);
    }

    public <O extends Record> Carriers(Table<O> path, ForeignKey<O, CarriersRecord> childPath, InverseForeignKey<O, CarriersRecord> parentPath) {
        super(path, childPath, parentPath, CARRIERS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class CarriersPath extends Carriers implements Path<CarriersRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> CarriersPath(Table<O> path, ForeignKey<O, CarriersRecord> childPath, InverseForeignKey<O, CarriersRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private CarriersPath(Name alias, Table<CarriersRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public CarriersPath as(String alias) {
            return new CarriersPath(DSL.name(alias), this);
        }

        @Override
        public CarriersPath as(Name alias) {
            return new CarriersPath(alias, this);
        }

        @Override
        public CarriersPath as(Table<?> alias) {
            return new CarriersPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CarriersRecord, Integer> getIdentity() {
        return (Identity<CarriersRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<CarriersRecord> getPrimaryKey() {
        return Keys.CARRIERS_PKEY;
    }

    private transient TicketsPath _tickets;

    /**
     * Get the implicit to-many join path to the <code>public.tickets</code>
     * table
     */
    public TicketsPath tickets() {
        if (_tickets == null)
            _tickets = new TicketsPath(this, null, Keys.TICKETS__TICKETS_CARRIER_ID_FKEY.getInverseKey());

        return _tickets;
    }

    @Override
    public Carriers as(String alias) {
        return new Carriers(DSL.name(alias), this);
    }

    @Override
    public Carriers as(Name alias) {
        return new Carriers(alias, this);
    }

    @Override
    public Carriers as(Table<?> alias) {
        return new Carriers(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Carriers rename(String name) {
        return new Carriers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Carriers rename(Name name) {
        return new Carriers(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Carriers rename(Table<?> name) {
        return new Carriers(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Carriers where(Condition condition) {
        return new Carriers(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Carriers where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Carriers where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Carriers where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Carriers where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Carriers where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Carriers where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Carriers where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Carriers whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Carriers whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
