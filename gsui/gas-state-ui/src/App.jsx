import Button from '@material-ui/core/Button';
import axios from 'axios';
import './App.css';
import { useSelector, useDispatch } from 'react-redux';
import GasStateInput from './components/GasStateInput';
import GasStateTable, { updateTableRows } from './components/GasStateTable';
import Header from './components/Header';
import {
  TEMPERATURE_CONSTANTS,
  PRESSURE_CONSTANTS,
} from './constants/constants';
import { addRow } from './redux/slices/tableSlice';

function App() {
  const temperature = useSelector(
    (state) => state.inputs[TEMPERATURE_CONSTANTS.id]
  );
  const pressure = useSelector((state) => state.inputs[PRESSURE_CONSTANTS.id]);

  const dispatch = useDispatch();

  function updateTableRows2(gasStateOutput2) {
    console.log({ gasStateOutput2 });
    dispatch(addRow(gasStateOutput2));
  }

  function submitGasStateRequest() {
    axios({
      method: 'post',
      url: 'http://localhost:8080/calculate',
      data: {
        firstInputType: 'TEMPERATURE',
        firstInputValue: temperature,
        secondInputType: 'PRESSURE',
        secondInputValue: pressure,
      },
    })
      .then((res) => updateTableRows2(res.data))
      .catch((err) => console.log(err));
  }

  return (
    <div className="container">
      <Header />
      <GasStateInput
        gasPropertyTypeId={TEMPERATURE_CONSTANTS.id}
        gasPropertyTypeDisplay="Temperature (K)"
      />
      <GasStateInput
        gasPropertyTypeId={PRESSURE_CONSTANTS.id}
        gasPropertyTypeDisplay="Pressure (Pa)"
      />
      <Button
        variant="contained"
        color="primary"
        style={
          {
            // fontSize: 24
          }
        }
        onClick={() => submitGasStateRequest()}
      >
        Calculate
      </Button>
      <GasStateTable />
    </div>
  );
}

export default App;
