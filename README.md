# sistema-cartao

## query proposta listando todos
```
select p.*
   from Proposta p
where
   p.status = 'ELEGIVEL'
order by p.dataRegistro asc
```

## query propostas top 50
```
select p.*
   from Proposta p
where
   p.status = 'ELEGIVEL'
order by p.dataRegistro asc
  limit 50
```

## query propostas lock pessimista
```
select p.*
   from Proposta p
where
   p.status = 'ELEGIVEL'
order by p.dataRegistro asc
  limit 50
  for update 
```

## query propostas skip locked 
```
select p.*
   from Proposta p
where
   p.status = 'ELEGIVEL'
order by p.dataRegistro asc
  limit 50
  for update skip locked
```