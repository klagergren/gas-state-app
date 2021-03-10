import React from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

function createData(
  index,
  temp,
  pressure,
  density,
  entropy,
  enthalpy,
  soundSpeed,
  energy
) {
  return {
    index,
    temp,
    pressure,
    density,
    entropy,
    enthalpy,
    soundSpeed,
    energy,
  };
}

const rows = [
  createData(1, 303, 50349, 0.2, 5, 21.3, 5, 6),
  createData(2, 303, 50349, 0.2, 5, 21.3, 5, 6),
];

const rowHeaders = [
  'Index',
  'Temperature',
  'Pressure',
  'Density',
  'Entropy',
  'Enthalpy',
  'Sound Speed',
  'Energy',
];

function GasStateTable() {
  const classes = useStyles();
  return (
    <div>
      <TableContainer component={Paper}>
        <Table className={classes.table} aria-label="simple table">
          <TableHead>
            <TableRow>
              {rowHeaders.map((rowHeader) => (
                <TableCell align="right" key={rowHeader}>
                  {rowHeader}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row) => (
              <TableRow key={row.index}>
                <TableCell component="th" scope="row" align="center">
                  {row.index}
                </TableCell>
                <TableCell align="right">{row.temp}</TableCell>
                <TableCell align="right">{row.pressure}</TableCell>
                <TableCell align="right">{row.density}</TableCell>
                <TableCell align="right">{row.entropy}</TableCell>
                <TableCell align="right">{row.enthalpy}</TableCell>
                <TableCell align="right">{row.soundSpeed}</TableCell>
                <TableCell align="right">{row.energy}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
}

export default GasStateTable;
