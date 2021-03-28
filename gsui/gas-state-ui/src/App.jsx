import Button from '@material-ui/core/Button';
import axios from 'axios';
import './App.css';
import { useSelector } from 'react-redux';
import GasStateInput from './components/GasStateInput';
import GasStateTable from './components/GasStateTable';
import Header from './components/Header';
import { TEMPERATURE_PROP_ID, PRESSURE_PROP_ID } from './constants/constants';

function App() {
  const temperature = useSelector((state) => state.inputs[TEMPERATURE_PROP_ID]);
  const pressure = useSelector((state) => state.inputs[PRESSURE_PROP_ID]);

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
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
  }

  return (
    <div className="container">
      <Header />
      <GasStateInput
        gasPropertyTypeId={TEMPERATURE_PROP_ID}
        gasPropertyTypeDisplay="Temperature (K)"
      />
      <GasStateInput
        gasPropertyTypeId={PRESSURE_PROP_ID}
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
