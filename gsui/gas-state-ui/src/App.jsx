import './App.css';
import Button from '@material-ui/core/Button';
import Select from '@material-ui/core/Select';
import Header from './components/Header';
import GasStateInput from './components/GasStateInput';
import GasStateTable from './components/GasStateTable';

function App() {
  return (
    <div className="container">
      <Header />
      <GasStateInput
        gasPropertyTypeId="temperature"
        gasPropertyTypeDisplay="Temperature (K)"
      />
      <GasStateInput
        gasPropertyTypeId="pressure"
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
        onClick={() => console.log('Hello')}
      >
        Calculate
      </Button>
      <GasStateTable />
    </div>
  );
}

export default App;
