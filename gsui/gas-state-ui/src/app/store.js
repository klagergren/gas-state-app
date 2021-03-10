import { configureStore } from '@reduxjs/toolkit';
import inputsReducer from '../redux/slices/inputSlice';

export default configureStore({
  reducer: {
    inputs: inputsReducer,
  },
});
