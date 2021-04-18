import React from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import { addRow } from '../redux/slices/tableSlice';
import store from '../app/store';
import {
  DENSITY_PROP_ID,
  ENERGY_PROP_ID,
  ENTHALPY_PROP_ID,
  ENTROPY_PROP_ID,
  PRESSURE_PROP_ID,
  SOUND_SPEED_PROP_ID,
  TEMPERATURE_PROP_ID,
} from '../constants/constants';

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

export function updateTableRows(gasStateOutput) {
  console.log({ gasStateOutput });
  store.dispatch(addRow(gasStateOutput));
}

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
                <TableCell align="right">{row[TEMPERATURE_PROP_ID]}</TableCell>
                <TableCell align="right">{row[PRESSURE_PROP_ID]}</TableCell>
                <TableCell align="right">{row[DENSITY_PROP_ID]}</TableCell>
                <TableCell align="right">{row[ENTROPY_PROP_ID]}</TableCell>
                <TableCell align="right">{row[ENTHALPY_PROP_ID]}</TableCell>
                <TableCell align="right">{row[SOUND_SPEED_PROP_ID]}</TableCell>
                <TableCell align="right">{row[ENERGY_PROP_ID]}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
}

export default GasStateTable;
